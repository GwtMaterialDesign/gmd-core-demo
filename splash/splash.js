var splashcontainer = document.createElement('div');
splashcontainer.id = "splashscreen";

var splashContent = document.createElement('div');

var image = document.createElement("img");
image.src = "https://gwtmaterialdesign.github.io/gmd-core-demo/launcher-icons/launcher2x.png";

var title = document.createElement("span");
title.className = "title";
title.innerHTML = "gwt-material-design";

var description = document.createElement("span");
description.className = "description";
description.innerHTML = "version 2.3.0";

var progress = document.createElement("div");
progress.className = "progress";

var progressFill = document.createElement("div");
progressFill.className = "indeterminate";
progress.appendChild(progressFill);

splashContent.appendChild(image);
splashContent.appendChild(title);
splashContent.appendChild(description);
splashContent.appendChild(progress);

splashcontainer.appendChild(splashContent);
document.body.appendChild(splashcontainer);