///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA 21+
//DEPS ai.djl:bom:0.33.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS org.slf4j:slf4j-simple:2.0.17

import static java.lang.System.out;

import java.nio.file.Path;

import ai.djl.Application;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.repository.zoo.Criteria;
import ai.djl.training.util.ProgressBar;

public class djl {

    static Path input = Path.of("3.png");

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
                .optApplication(Application.CV.IMAGE_CLASSIFICATION)
                .setTypes(Image.class, Classifications.class)
                .optArtifactId("mlp")
                .optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();
        var img = ImageFactory.getInstance().fromFile(input);
        try (var predictor = model.newPredictor()) {
            var classifications = predictor.predict(img);
            out.println(classifications);
            out.println("Answer = %s".formatted(classifications.best().getClassName()));
        }
    }
}
