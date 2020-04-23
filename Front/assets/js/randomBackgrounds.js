function generate() {
    document.getElementsById("12345").style.background = '#'+(1e8^Math.random()*(1<<24)).toString(16).slice(1);
  }