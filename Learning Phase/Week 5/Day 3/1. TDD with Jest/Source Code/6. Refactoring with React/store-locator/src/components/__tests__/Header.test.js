import React from "react";
import { shallow } from "enzyme";
import Header from "../Header";

describe("Header", function () {
  let mountedHeader;

  beforeEach(() => {
    mountedHeader = shallow(<Header />);
  });

  it("renders without crashing", () => {
    let mountedHeader = shallow(<Header />);
  });

  it("renders a logo", () => {
    const logoImg = mountedHeader.find("img");
    expect(logoImg.getElement(0).props.src).toEqual(
      "images/wired-brain-coffee-logo.png"
    );
  });
});
