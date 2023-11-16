import mapChooser from "../mapChooser";

describe("mapChooser", function () {
  it("returns an image based on input given to it", function () {
    let expected = "portland.png";
    let actual = mapChooser("portland");
    expect(actual).toEqual(expected);
  });

  it("returns a default image when no input is given", function () {
    let expected = "none.png";
    let actual = mapChooser("");
    expect(actual).toEqual(expected);
  });
});
