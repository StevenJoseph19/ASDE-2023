import mapChooser from '../mapChooser';



// describe("mapChooser", function(){
//     it("returns an image file name based on input given to it", function() {
//        let expected = "portland.jpg";
//        let actual = mapChooser("portland");
//        expect(actual).toEqual(expected);
//     });
  
// });

// describe("mapChooser", function(){
//     it("returns portland.jpg when portland is passed to it", function() {
//        let expected = "portland.jpg";
//        let actual = mapChooser("portland");
//        expect(actual).toEqual(expected);
//     });
//     it("returns astoria.jpg when portland is passed to it", function() {
//         let expected = "astoria.jpg";
//         let actual = mapChooser("astoria");
//         expect(actual).toEqual(expected);
//      });
// });

describe("mapChooser", function(){
    it("returns an image based on input given to it", function() {
       let expected = "portland.jpg";
       let actual = mapChooser("portland");
       expect(actual).toEqual(expected);
    });
    it("returns an default image when no input is given", function() {
        let expected = "default.jpg";
        let actual = mapChooser("");
        expect(actual).toEqual(expected);
    });
});

// describe("mapChooser", function(){
//     it("returns an image based on input given to it", function() {
//        let expected = "portland.png";
//        let actual = mapChooser("portland");
//        expect(actual).toEqual(expected);
//     });
//     it("returns an default image when no input is given", function() {
//         let expected = "none.png";
//         let actual = mapChooser("");
//         expect(actual).toEqual(expected);
//     });
// });

