SUMMARY = "AWS C SDKUTILS"
DESCRIPTION = "No description or website provided. "

HOMEPAGE = "https://github.com/awslabs/aws-c-sdkutils"
LICENSE = "Apache-2.0"
PROVIDES += "aws/c-sdkutils"

inherit cmake

LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI = "git://github.com/awslabs/aws-c-sdkutils.git;protocol=https;branch=main"

SRCREV = "1986e346e0b963f073aab3b90a82713f85334890"

S = "${WORKDIR}/git"

DEPENDS = "aws-c-common"
RDEPENDS:${PN} = "aws-c-common"

CFLAGS:append = " -Wl,-Bsymbolic"
EXTRA_OECMAKE += " \
    -DBUILD_TESTING=OFF \
    -DCMAKE_MODULE_PATH=${STAGING_LIBDIR}/aws-c-common/cmake \
    -DCMAKE_MODULE_PATH=${STAGING_LIBDIR}/cmake \
    -DCMAKE_PREFIX_PATH=$D/usr \
    -DCMAKE_INSTALL_PREFIX=$D/usr \
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_BUILD_TYPE=Release \
"

FILES:${PN}-dev += "${libdir}/*/cmake"