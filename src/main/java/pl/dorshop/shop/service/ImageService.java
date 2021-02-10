package pl.dorshop.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dorshop.shop.model.Image;
import pl.dorshop.shop.repository.ImageDbRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageDbRepository imageDbRepository;

    public Long addImage(Image image) {

        return imageDbRepository.save(image).getId();
    }

    public void deleteImage(Image image) {
        imageDbRepository.delete(image);
    }

    public Optional<Image> findById(long id){
        return imageDbRepository.findById(id);
    }

    public List<Image> imageList(){
        return imageDbRepository.findAll();
    }

}
