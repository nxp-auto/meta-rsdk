#
#   Copyright 2021 NXP
#   BitBake layer for SPT libraries build
#

DESCRIPTION = "SPT Library"

# include general library parameters
require recipes-libs/rsdk_lib.inc

# the specific external path to be used
EXTERNALSRC := "${RSDK_PATH}/SPT/SPT_driver"
EXTERNALSRC_BUILD = "${EXTERNALSRC}/build"

# the target(s) name(s)
RSDK_LIB_DIR = "../bin"
RSDK_LIB = "librsdk_SPT_driver_linux_gcc_S32R45_a53*.a"

# the final targets to be used for cte libraries build
MAKE_TARGETS = "release debug"
