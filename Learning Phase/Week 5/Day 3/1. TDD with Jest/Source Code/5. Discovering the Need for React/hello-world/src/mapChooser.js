function mapChooser(locationName){
    if (!locationName) {
        locationName = "default";
    }
    let imageName = locationName + ".jpg";
    return (imageName);
}

export default mapChooser;
