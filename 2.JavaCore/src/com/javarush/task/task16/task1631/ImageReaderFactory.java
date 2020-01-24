package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory implements ImageReader {

    public static ImageReader getImageReader(final ImageTypes imageTypes) {
        ImageReader imageReader;

        if(imageTypes == ImageTypes.BMP)
            imageReader = new BmpReader();
        else if(imageTypes == ImageTypes.JPG)
            imageReader = new JpgReader();
        else if(imageTypes == ImageTypes.PNG)
            imageReader = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");

        return imageReader;

    }

}
