#
#   Copyright 2021 NXP
#   BitBake layer description for Linux kernel build
#

# path to be used for defined files
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# files to be used at Linux kernel time : 
#   .config = Linux configuration changes
#   .diff = patch to the current Linux files (mainly dts/dtsi S32R45EVB files)
SRC_URI += "\
    file://s32r45_updates_for_linux5.10.config \
    file://bsp33_patch.diff \
"

# explicit Linux config changes to be added
DELTA_KERNEL_DEFCONFIG_append += "s32r45_updates_for_linux5.10.config"
