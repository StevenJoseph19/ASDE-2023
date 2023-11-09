var SteamEngine = {
  color: "blue",
  get name() {
    return "Thomas";
  },
  start() {
    console.log("Hurry up!");
  },
  stop() {
    console.log("Screech...! That was close.");
  },
};

console.log("My name is", SteamEngine.name);
SteamEngine.start();
SteamEngine.stop();
