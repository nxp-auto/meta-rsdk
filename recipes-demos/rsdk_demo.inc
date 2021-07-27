#
#   Copyright 2021 NXP
#   General definitions for RSDK layer environment
#

require recipes-core/rsdk_env.inc

LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://${RSDK_EULA_FILE};md5=b174f4d7ce08c66847ee7f942e8a4e0d"

# parameters to be used at build time
EXTRA_OEMAKE += 'PLATFORM=S32R45 \
	TARGET=a53 \
	OSENV=linux \
	COMPILER=gcc \
	CC="${CC}" \
	AR="${AR}"'

RSDK_BIN_DIR ?= "bin"
EXTERNALSRC_BUILD ?= "${EXTERNALSRC}"

# the application destination in the Linux file system
RSDK_DEMO_DEST = "/opt/rsdk/demos"

# specific install sequence
do_install () {
         install -d ${D}${RSDK_DEMO_DEST}
         install -m 0644 ${B}/${RSDK_BIN_DIR}/${RSDK_BIN} ${D}${RSDK_DEMO_DEST}
}

# specific files definitions
FILES_${PN} = "${RSDK_DEMO_DEST}/${RSDK_BIN}"
