SUMMARY = "Universal Command Line Interface for Amazon Web Services"
HOMEPAGE = "https://github.com/aws/aws-cli"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7970352423db76abb33cbe303884afbf"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7970352423db76abb33cbe303884afbf"

SRC_URI = "git://github.com/aws/aws-cli.git;protocol=https;branch=master"
SRCREV = "085211eddad2cb28ac430ce43e548a1c42f601f5"
S = "${WORKDIR}/git"

# version 2.x has got library link issues - so stick to version 1.x for now
UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>1\.\d+(\.\d+)+)"

inherit setuptools3 ptest

RDEPENDS:${PN} += " \
    python3-botocore \
    python3-docutils \
    python3-s3transfer \
    python3-pyyaml \
    python3-colorama \
    python3-distro \
    python3-unixadmin \
    python3-ruamel-yaml \
    python3-prompt-toolkit \
    python3-sqlite3 \
    python3-misc \
    python3-rsa \
    python3-dateutil \
    python3-urllib3 \
    python3-jmespath \
    groff \
"

RDEPENDS:${PN}-ptest += " \
        ${PYTHON_PN}-pytest \
        bash \
"

SRC_URI += " \
	file://run-ptest \
"

do_install_ptest() {
        install -d ${D}${PTEST_PATH}/test
        cp -rf ${S}/tests/* ${D}${PTEST_PATH}/test/
}
