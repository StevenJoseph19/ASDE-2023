// const path = require("path");
const fs = require("fs");

// const files = [".bash_profile", ".npmrc"];
const files = ["./1-loop.js", ".zzz.js", "./2-try.js"];

files.forEach((file) => {
  // console.log(process.env.HOME);
  // console.log(__dirname);
  // const filePath = path.resolve(process.env.HOME, file);
  // const filePath = path.resolve(__dirname, file);

  // console.log(filePath);
  // const data = fs.readFileSync(filePath);
  const data = fs.readFileSync(file);
  console.log("File data is", data);
});
