#
#   Copyright 2021-2023 NXP
#   BitBake layer description for O[S]AL kernel library
#

DESCRIPTION = "OSAL Linux Kernel Library"
LICENSE = "GPL-2.0-only"
inherit module

# include the general rsdk kernel build parameters
require recipes-core/rsdk_env.inc


# setup for Bitbucket
inherit externalsrc

# adjust the EXTERNALSRC to the real make file to be used
EXTERNALSRC := "${RSDK_PATH}/oal"
EXTERNALSRC_BUILD = "${RSDK_PATH}/oal/libs/kernel/linux-write/build-linux-kernel"
EXTRA_OEMAKE += " CDEFS+=' -DOAL_MAX_EVENTS_PER_SERVICE=64U -DOAL_MAX_PROCESS_COMM_SHARED_BUFFER=15000 -DOAL_MAX_REGION_SIZE=0xFFFFFFFFU -DOAL_VAS_MAX_ALLOCATION=0xFFFFFFFFU -DOAL_MAX_PHYS_ALLOCATION_PER_CHUNK=0xFFFFFFFFU ' "
MDIR = "${RSDK_PATH}/oal/libs/kernel/linux-write/build-linux-kernel"

# other general and specific OSAL library build parameters
LIC_FILES_CHKSUM = "file://${RSDK_PATH}/oal/COPYING.BSD;md5=c3f054326d84bba08b641ced67486a4c"

# patch for OAL make environment
SRC_URI += "\
file://linux_5.15_osal_patch.diff \
"


# other patch definitions
do_patch_drv[depends] = "quilt-native:do_populate_sysroot"

addtask do_patch_drv after do_unpack before do_compile

python do_patch_drv() {
    bb.build.exec_func('patch_do_patch', d)
}

do_install() {
}



###########################################################################
# setup for CodeAurora, kept as reference
#URL = "git://source.codeaurora.org/external/autobsps32/extra/radar_drv;protocol=http"
#BRANCH = "master"
#SRCREV = "edc9cedb47d510d15a43539be749f9e766943cfa"
#SRC_URI = "${URL};branch=${BRANCH}"
#S = "${WORKDIR}/git"
#RSDK_PATH ?= "${S}"
#export RSDK_PATH
#MDIR = "${RSDK_PATH}/oal/libs/kernel/linux-write/build-linux-kernel"
#DESTDIR = "${D}"
#export DESTDIR
#LOCAL_CONFIGDIR ?= "output"
#SRC_CONFIGDIR = "${THISDIR}/${LOCAL_CONFIGDIR}"
#export SRC_CONFIGDIR
#
#python do_fetch() {
#    print("target : ", d.getVar('WORKDIR'))
#    src_base = d.getVar('SRC_URI')
#    src_uri = (src_base).split()
#    print("SRC_URI : ", src_uri)
#    fetcher = bb.fetch2.Fetch(src_uri, d)
#    fetcher.download()
#}
