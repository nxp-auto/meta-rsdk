#
#   Copyright 2021-2023 NXP
#   BitBake general layer parameters for rsdk libraries build
#   For the current recipe the libraries are not built, because of the used compilers :
#   gcc 10.2 for Linux/modules and gcc 9.2 for libraries/applications
#

# include the rsdk environment parameters
require recipes-core/rsdk_env.inc

# license
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://${RSDK_EULA_FILE};md5=b174f4d7ce08c66847ee7f942e8a4e0d"

# supplementary build parameters
EXTRA_OEMAKE += 'PLATFORM=S32R45 \
	TARGET=a53 \
	OSENV=linux \
	COMPILER=gcc \
	CC="${CC}" \
	AR="${AR}"'

# the specific build target
MAKE_TARGETS ?= "release"

# the target directory for library deployment
RSDK_LIB_DIR ?= "bin"
EXTERNALSRC_BUILD ?= "${EXTERNALSRC}"

# other specific build 
do_compile () {
	oe_runmake ${MAKE_TARGETS}
}

do_install () {
         install -d ${D}${libdir}
         install -m 0644 ${B}/${RSDK_LIB_DIR}/${RSDK_LIB} ${D}${libdir}
}

FILES_${PN} = "${libdir}/${RSDK_LIB}"
