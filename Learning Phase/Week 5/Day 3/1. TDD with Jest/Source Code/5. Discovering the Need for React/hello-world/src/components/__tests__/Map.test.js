import React from 'react';
import {shallow} from 'enzyme';
import Map from '../Map';


describe("Map",function(){
    // let mountedMap;
    // beforeEach(()=>{
    //     mountedMap = shallow(<Map />);
    // });

    it('renders without crashing', () => {
        let mountedMap = shallow(<Map />);
    });

    // it('contains a image', () => {
    //     const img = mountedMap.find('img');
    //     expect(img.length).toBe(1);
    // });

    // it('displays the none map when no params are given',()=>{
    //     const defaultMap = mountedMap.find('img [src="images/none.png"]');
    //     expect(defaultMap.length).toBe(1);
    // })
});
