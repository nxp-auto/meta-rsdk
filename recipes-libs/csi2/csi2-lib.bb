#
#   Copyright 2021-2023 NXP
#   BitBake layer for CSI2 libraries build
#

DESCRIPTION = "CSI2 Library"

# include general library parameters
require recipes-libs/rsdk_lib.inc

# the specific external path to be used
EXTERNALSRC := "${RSDK_PATH}/CSI2/CSI2_driver"
EXTERNALSRC_BUILD = "${EXTERNALSRC}"

# the target(s) name(s)
RSDK_LIB = "librsdk_CSI2_driver_linux_gcc_S32R45_a53*.a"

# the final targets to be used for csi2 libraries build
MAKE_TARGETS = "release debug"

