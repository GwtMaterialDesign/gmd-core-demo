#!/bin/bash
set -ev
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ]  && [ "$TRAVIS_BRANCH" == "release_2.4.0" ]; then

if [[ -z "$GH_TOKEN" ]]; then
echo -e "GH_TOKEN is not set"
exit 1
fi

if [ ! -f $TRAVIS_BUILD_DIR/target/GmdCoreDemo*.war ]; then
echo -e "demo war file not found."
exit 1
fi

echo -e "Publishing demo to gh-pages . . .\n"

git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"

# clone the gh-pages branch.
cd $HOME
rm -rf gh-pages
git clone --quiet --branch=gh-pages https://$GH_TOKEN@github.com/GwtMaterialDesign/gmd-core-demo gh-pages > /dev/null
cd gh-pages

# remove the GmdCoreDemo Snapshot directories from git.
if [[ -d ./snapshot/ ]]; then
git rm -rf ./snapshot/
fi

# copy the new GmdCoreDemo the snapshot dir.
unzip -u $TRAVIS_BUILD_DIR/target/GmdCoreDemo*.war -d ./snapshot/

git add -f .
git commit -m "Auto-push demo to gh-pages successful. (Travis build: $TRAVIS_BUILD_NUMBER)"
git push -fq origin gh-pages > /dev/null

echo -e "Published demo to gh-pages.\n"

fi