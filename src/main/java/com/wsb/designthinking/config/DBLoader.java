package com.wsb.designthinking.config;

import com.wsb.designthinking.OpinionRepository;
import com.wsb.designthinking.model.Opinion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBLoader implements CommandLineRunner {

    private OpinionRepository opinionRepository;

    public DBLoader(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Opinion firstOpinion = new Opinion();
        firstOpinion.setName("Krzysztof Cz.");
        firstOpinion.setPostalCode("43-400");
        firstOpinion.setReceipeNumber(16234);
        firstOpinion.setEmail("krzysztof@onet.pl");
        firstOpinion.setAddedTime("2020-09-05 16:22:34");
        firstOpinion.setComment("Wszystko w jak najlepszym porządku, napewno tam wrócę :)");
        opinionRepository.save(firstOpinion);

        Opinion secondOpinion = new Opinion();
        secondOpinion.setName("Magda Gessler");
        secondOpinion.setPostalCode("45-000");
        secondOpinion.setReceipeNumber(16235);
        secondOpinion.setEmail("kuchennerewolucje@tvn.pl");
        secondOpinion.setAddedTime("2020-12-10 13:26:34");
        secondOpinion.setComment("Polecam, Magda Gessler");
        opinionRepository.save(secondOpinion);
    }
}
