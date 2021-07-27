#
#   Copyright 2021 NXP
#   General definitions for LAX library recipe
#

DESCRIPTION = "LAX Library"

# include the general library parameters
require recipes-libs/rsdk_lib.inc

# real external paths
EXTERNALSRC := "${RSDK_PATH}/LAX/LAX_host/driver/lax_user/build-linux-user"
EXTERNALSRC_BUILD = "${EXTERNALSRC}"
RSDK_LIB_DIR = "./../../../../LAX_bin"
RSDK_LIB = "librsdk_lax_user_linux_gcc_S32R45_a53.a"

# the necessary target for LAX library build
MAKE_TARGETS = "lib_linux_release"
EXTRA_OEMAKE += " OS=linux"