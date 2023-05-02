#
#   Copyright 2021-2023 NXP
#   BitBake layer for OSAL libraries build
#

DESCRIPTION = "OSAL Library"
LICENSE = "BSD"

# include general rsdk layer parameters
require recipes-core/rsdk_env.inc

# license
LIC_FILES_CHKSUM = "file://${RSDK_PATH}/oal/COPYING.BSD;md5=c3f054326d84bba08b641ced67486a4c"

# specific external path
EXTERNALSRC := "${RSDK_PATH}/oal"
EXTERNALSRC_BUILD = "${RSDK_PATH}/oal/libs/user/linux-write/build-linux-user"

# Build release version of the library
EXTRA_OEMAKE += " OAL_BUILD_CONFIG=release OBJDIR=."

# other yocto build definitions
do_install () {
         install -d ${D}${libdir}
         install -m 0644 ${B}/liboal_user.a ${D}${libdir}
}

FILES_${PN} = "${libdir}/liboal_user.a"
