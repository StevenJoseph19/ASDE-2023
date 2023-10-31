/* var CSS3Demos = (function () {
  function isSelectorSupported(anySelector) {
    var newStyle = document.createElement("style"),
      cssRule = anySelector + "{}",
      isSupported = false,
      styles,
      rules,
      selectorText;
    newStyle.type = "text/css";
    if (newStyle.styleSheet) {
      styles = newStyle.styleSheet;
      if (styles.cssText) {
        styles.cssText = cssRule;
        if (styles.rules) {
          rules = styles.rules;
          if (rules[0].selectorText) {
            selectorText = rules[0].selectorText.toLowerCase();
            isSupported = selectorText.indexOf("unknown") < 0;
          }
        }
      }
    } else {
      newStyle.appendChild(document.createTextNode(cssRule));
      document.body.appendChild(newStyle);
      isSupported = !!newStyle.sheet.cssRules.length;
      document.body.removeChild(newStyle);
    }
    return isSupported;
  }
  return {
    isSelectorSupported: isSelectorSupported,
  };
})(); */

// executes when page is loaded
$(function () {
  // behavior if :target not supported
 /*  if (!CSS3Demos.isSelectorSupported(":target")) {
    var pages = $("#topics, #about, #contact, #intro");
    $("nav a").click(function () {
      pages.css("z-index", "-1");
      $($(this).attr("href")).css("z-index", "2");
    });
  } */
  // toggle animation by click
  // var msg = $("#intro div");
  // $("nav a[href=#intro]").click(function () {
  //   msg.toggleClass("introClicked");
  // });
  // $("nav a:not([href=#intro])").click(function () {
  //   msg.removeClass("introClicked");
  // });
  // msg.toggleClass("introClicked");
});
