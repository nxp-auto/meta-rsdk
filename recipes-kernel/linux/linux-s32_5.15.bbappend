#
#   Copyright 2023 NXP
#   BitBake layer description for Linux kernel build
#

# path to be used for defined files
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# files to be used at Linux kernel time : 
#   .config = Linux configuration changes
#   .diff = patch to the current Linux files (mainly dts/dtsi S32R45EVB files)
SRC_URI += "\
    file://s32r45_updates_for_linux5.15.config \
    file://bsp37_patch.diff \
"


# explicit Linux config changes to be added
DELTA_KERNEL_DEFCONFIG:append += "s32r45_updates_for_linux5.15.config"
