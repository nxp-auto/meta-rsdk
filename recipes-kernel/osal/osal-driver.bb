#
#   Copyright 2021 NXP
#   BitBake layer description for O[S]AL driver
#

DESCRIPTION = "OS Abstraction Layer driver"
LICENSE = "GPLv2"
inherit module
inherit externalsrc

# to be built after OAL kernel library is built
DEPENDS = "osal-kernel-lib"

# include the general rsdk kernel build parameters
require recipes-core/rsdk_env.inc

# EXTERNALSRC for CodeAurora processing
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/oal"

EXTERNALSRC_BUILD = "${EXTERNALSRC}/libs/kernel/driver/build-linux-kernel"

# supplementary definitions
export CDEFS = " -DOAL_MAX_EVENTS_PER_SERVICE=64U -DOAL_MAX_PROCESS_COMM_SHARED_BUFFER=15000 -DOAL_MAX_REGION_SIZE=0xFFFFFFFFU -DOAL_VAS_MAX_ALLOCATION=0xFFFFFFFFU -DOAL_MAX_PHYS_ALLOCATION_PER_CHUNK=0xFFFFFFFFU "

# other very specific OSAL build parameters
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
LIC_FILES_CHKSUM = "file://${EXTERNALSRC}/COPYING.BSD;md5=c3f054326d84bba08b641ced67486a4c"

# patch for OAL make environment
#SRC_URI += "\
#    file://bsp28.0_osal_patch.diff \
#"


# other patch definitions
do_patch_drv[depends] = "quilt-native:do_populate_sysroot"

addtask do_patch_drv after do_unpack before do_compile

python do_patch_drv() {
    bb.build.exec_func('patch_do_patch', d)
}


