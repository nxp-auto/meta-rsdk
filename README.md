Copyright 2021 NXP


# Yocto layer for NXP Auto Radar SDK

How to build the specific RadarSDK Linux image in only one step, including RadarSDK Linux modules.
The RadarSDK layer is built on top of BSP Linux layer and is connected to a specific BSP release.
The current implementation is using BSP 35.0 with yocto 3.2.

## 1. Preliminary steps

To finalize this build you need to have `repo` installed and its prerequisites. This only needs to be done once.
This recipe was tested on Ubuntu 18.4 and 20.4 distributions.

Dependencies to be installed:

- `python` 3.x preferred ($: sudo install python)
- `git` 2.x or newer ($: sudo install git)
- `curl` ($: sudo install curl) where is the package manager for your distribution (apt-get for Ubuntu).
Install the `repo` utility:
```bash
$: mkdir ~/bin 
$: curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo 
$: chmod a+x ~/bin/repo 
$: PATH=${PATH}:~/bin
```
Meta sdk recipes do not download RSDK code. It needs to be downloaded manually. 

## 2. Initialize the repository

To be able to complete the build, around 60 GB of disk space will be necessary.

First step : create an empty directory, let's call it `rsdk-yocto-build`, for further usage, but you can use any name you want.
```bash
$: mkdir rsdk-yocto-build
```

Second step : initialize the repository. 

If using the recipe from Bitbucket, the commands are:
```bash
$: cd rsdk-yocto-build 
$: repo init -u ssh://git@bitbucket.sw.nxp.com/radarsw/rsdk-manifest.git [-b branch_name] -m <manifest_file>
```

If using the recipe from GitHub, the commands are:
```bash
$: cd rsdk-yocto-build 
$: repo init -u https://github.com/nxp-auto/radar_manifests [-b branch_name] -m rsdk-ca.xml
```

If the parameter [-b branch_name] is missing, the develop branch will be used for Bitbucket and master for GitHub. A specific branch can be used only if you have a correct information.
According to the RadarSDK sources access, for manifest_file, must be used :
- rsdk-ca.xml - for GitHub repository; all files (yocto recipes and RadarSDK files) will be taken from GitHub
- rsdk-bitbucket.xml - for NXP Bitbucket repository; all files must be taken from Bitbucket independently
For GitHub build, only rsdk-ca.xml file can be used, only complete GitHub build is possible.

Third step : synchronize the repository.
```bash
$: repo sync
```
Fourth step : RSDK_PATH must be defined. It can be define adding the below line in conf/local.conf of your ‘build_<machine>’ director. 
```
 RSDK_PATH ?= "<path>/rsdk"
```

## 3. Initialize the recipe environment

As RadarSDK yocto is built on top of BSP yocto built, the RadarSDK layer must be added at the initialization time.
```bash
$: source nxp-setup-alb.sh -m s32r45renan -e meta-rsdk
```
If the `meta-rsdk` layer is not specified at the first environment initialization, the RadarSDK layer will not be included in the Linux image built.
Yocto build can't be started (using bitbake command) without environment initialization, which must be done for each new shell. 
Only for the first time `-e meta-rsdk` is necessary, for each other time you can use a shorter command :
```bash
$: source nxp-setup-alb.sh -m s32r45evb
```
From BSP 43.0, the default version of kernel is v6.6.52. In case of need, the kernel can be changed to 5.15.167 by
adding the following line into the conf/local.conf file of your ‘build_<machine>’ director. 
```bash
PREFERRED_VERSION_linux-s32 = "5.15.167"
```
BSP 43.0 Known Issues/Limitations:
	ALB10563 - Renan board fails to boot with kernel 6.6. Add UART node in Renan board’s DTS or boot with kernel 5.15

Ipcf version can be controlled adding the following line into the conf/local.conf:
```bash
BRANCH:pn-ipc-shm="release/SW32R45_IPCF_4.6.0_D2409"
SRCREV:pn-ipc-shm="${AUTOREV}"
IMAGE_INSTALL:append = " ipc-shm"
```

## 4. Build the Linux image

To build the Linux SD card image using GitHub files, type this command :
```bash
$: bitbake fsl-image-auto
```
To build the Linux image Flash image using GitHub files, following steps are required:
- Apply patch meta-alb-renan-flash-image.patch to the meta-alb 
```bash
$: bitbake fsl-image-flash
```

## 5. Get the image

The image can be found in `rsdk-yocto-build/build_s32r45evb/tmp/deploy/images/s32r45renan` and is named `fsl-image-auto-s32r45evb....sdcard`.
At this moment the image is less than 800MB. Use an appropriate burning application to write it on a SD card.
Put the card in the S32R45 board and enjoy the Linux and RadarSDK.

## 6. Get RENAN and Hailo

As RadarSDK yocto is built on top of BSP yocto built, the RadarSDK layer must be added at the initialization time.
```bash
$: source nxp-setup-alb.sh -m s32r45renan -e "meta-rsdk meta-hailo/meta-hailo-accelerator meta-hailo/meta-hailo-libhailort"
```
Add the following packages in the the file conf/local.conf inside the "build" directory
```
IMAGE_INSTALL:append = "libhailort hailortcli pyhailort hailo-pci hailo-firmware"
```
Build the Linux SD card image :
```bash
$: bitbake fsl-image-auto
```