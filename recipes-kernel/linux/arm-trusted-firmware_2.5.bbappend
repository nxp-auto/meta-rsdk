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
    file://arm_trusted_firmware_patch.diff \
"

