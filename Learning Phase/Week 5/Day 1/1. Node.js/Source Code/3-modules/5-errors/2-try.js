const fs = require("fs");

const files = ["./1-loop.js", ".zzz.js", "./2-try.js"];

files.forEach((file) => {
  try {
    const data = fs.readFileSync(file, "utf-42");
    console.log("File data is", data);
  } catch (err) {
    console.log("File not found");
  }
});
