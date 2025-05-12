#
#   Copyright 2023 NXP
#   BitBake layer description for Linux u-boot build
#

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Support for generating default environment
SRC_URI += " \
   file://renan-u-boot.diff \
"
