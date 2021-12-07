#
#   Copyright 2021 NXP
#   BitBake layer description for O[S]AL kernel library
#

# General parameters
DESCRIPTION = "OSAL Linux Kernel Library"
LICENSE = "GPLv2"
inherit module

# include the general rsdk kernel build parameters
require recipes-core/rsdk_env.inc

# setup for CodeAurora
URL = "git://source.codeaurora.org/external/autobsps32/extra/radar_drv;protocol=http"
BRANCH = "master"
SRCREV = "4e10482ee78f0e1db658f0b183c402635d97866c"
SRC_URI = "${URL};branch=${BRANCH}"
S = "${WORKDIR}/git"
RSDK_PATH ?= "${S}"
export RSDK_PATH
MDIR = "${RSDK_PATH}/oal/libs/kernel/linux-write/build-linux-kernel"
DESTDIR = "${D}"
export DESTDIR
LOCAL_CONFIGDIR ?= "output"
SRC_CONFIGDIR = "${THISDIR}/${LOCAL_CONFIGDIR}"
export SRC_CONFIGDIR

# patch for OAL make environment
SRC_URI += "\
    file://linux_5.10_osal_patch.diff \
"

# specific module procedures
python do_fetch() {
    print("target : ", d.getVar('WORKDIR'))
    src_base = d.getVar('SRC_URI')
    src_uri = (src_base).split()
    print("SRC_URI : ", src_uri)
    fetcher = bb.fetch2.Fetch(src_uri, d)
    fetcher.download()
}

do_install() {
}

# other general and specific OSAL library build parameters
LIC_FILES_CHKSUM = "file://${RSDK_PATH}/oal/COPYING.BSD;md5=c3f054326d84bba08b641ced67486a4c"
