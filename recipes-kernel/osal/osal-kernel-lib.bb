#
#   Copyright 2021-2023 NXP
#   BitBake layer description for O[S]AL kernel library
#

# General parameters
DESCRIPTION = "OSAL Linux Kernel Library"
LICENSE = "GPL-2.0-only"
inherit module

# include the general rsdk kernel build parameters
require recipes-core/rsdk_env.inc

# setup for GitHub
URL = "git://github.com/nxp-auto/radar_prj;protocol=http"
BRANCH = "release/1.2.0"
SRCREV = "4e9039bc4711c9c83ddf1f0d58bd5b219a5993f3"
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
file://linux_5.15_osal_patch.diff \
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
