//package pl.dorshop.shop.controller;
//
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//import pl.dorshop.shop.model.Image;
//import pl.dorshop.shop.service.ImageService;
//
//import javax.annotation.Resource;
//
//@RestController
//public class ImageController {
//    private static ImageService imageService;
//
//    @PostMapping
//    public Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
//        Image dbImage = new Image();
//        dbImage.setName(multipartImage.getName());
//        dbImage.setContent(multipartImage.getBytes());
//        return imageService.addImage(dbImage);
//    }
//
//    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
//    Resource downloadImage(@PathVariable Long imageId) {
//        byte[] image = imageService.findById(imageId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
//                .getContent();
//
//        return new ByteArrayResource(image);
//    }
//}
