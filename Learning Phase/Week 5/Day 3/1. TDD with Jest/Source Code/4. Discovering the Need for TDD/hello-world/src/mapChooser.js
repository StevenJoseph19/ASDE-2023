function mapChooser(locationName){
    // return "portland.jpg";
    // return (locationName +".jpg");
    // if (locationName=== undefined) {
      if (!locationName) {
        locationName = "default";
    }
    let imageName = locationName + ".jpg";
    return (imageName);

    // if (!locationName) {
    //     locationName = "none";
    // }
    // let imageName = locationName + ".png";
    // return (imageName);
}

export default mapChooser;
