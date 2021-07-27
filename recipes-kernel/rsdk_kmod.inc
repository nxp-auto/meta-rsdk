#
#   Copyright 2021 NXP
#   General definitions for RSDK modules build
#

# inherit the RSDK environment definitions
require recipes-core/rsdk_env.inc

# inherit the general classes
inherit module kernel-module-split pkgconfig

# the kernel modules need osal/oal kernel library
DEPENDS += "osal-kernel-lib"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"


# other supplementary parametrs for make module command
EXTRA_OEMAKE += "PLATFORM=S32R45 \
	TARGET=a53 \
	COMPILER=gcc \
	OSENV=linux \
	OS=linux \
"

# the implemented target for module make
MAKE_TARGETS = "module"

# specific Linux build files definitions
FILES_${PN} += "${base_libdir}/*"
FILES_${PN} += "${sysconfdir}/modprobe.d/*"
