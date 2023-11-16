import React from "react";
import { shallow } from "enzyme";
import Map from "../Map";

describe("Map", function () {
  let mountedMap;
  let props;

  beforeEach(() => {
    props = {
      location: undefined,
      imagename: "testmap.png",
    };
    mountedMap = shallow(<Map {...props} />);
  });

  it("renders without crashing", () => {
    let mountedMap = shallow(<Map />);
  });

  // it("contains an image", () => {
  //   const img = mountedMap.find("img");
  //   expect(img.length).toBe(1);
  // });

  // it("displays the none map when no params are given", () => {
  //   // let defaultMap = shallow(<Map />);
  //   // const defaultImage = defaultMap.find("img");
  //   const defaultImage = mountedMap.find("img");
  //   expect(defaultImage.getElement(0).props.src).toEqual("images/none.png");
  //   expect(defaultImage.length).toBe(1);
  // });

  // it("displays the map imagename passed to it", () => {
  //   const mountedImage = mountedMap.find("img");
  //   expect(mountedImage.getElement(0).props.src).toEqual("images/testmap.png");
  //   expect(mountedImage.length).toBe(1);
  // });
});
