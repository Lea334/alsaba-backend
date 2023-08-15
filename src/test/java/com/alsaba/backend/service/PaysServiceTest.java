package com.alsaba.backend.service;


import com.alsaba.backend.model.Pays;
import com.alsaba.backend.repository.PaysRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaysServiceTest {

    @Autowired
    PaysRepository paysRepository ;

    @Autowired
    PaysService paysService ;

    Pays pays ;
    Pays resultat ;

    @BeforeAll
    void createPaysObject(){
         pays = new Pays(
                "Guinée" ,
                "1534" ,
                "FGF" ,
                "Conakry" ,
                1200 ,
                1455
        ) ;
    }

    /*
    * @goodCasesTest
    *
    */
    @Test
    @Order(1)
    void create() {

        resultat = paysService.create(pays);
        assertThat(resultat.getNom()).isEqualTo("Guinée");
        assertThat(resultat.getCode()).isEqualTo(1534) ;
        assertThat(resultat.getDevise()).isEqualTo("FGF") ;
        assertThat(resultat.getCapitale()).isEqualTo("Conakry") ;
        assertThat(resultat.getFrais()).isEqualTo(1200) ;
        assertThat(resultat.getTaux_echange()).isEqualTo(1455) ;

    }

    @Test
    @Order(2)
    void update() {
        resultat.setNom("Ghana");
        resultat.setCapitale("accrra");
        Pays updatedPays = paysService.update(resultat);
        Optional<Pays> findedUpdate = paysRepository.findById(resultat.getId());

        assertThat(findedUpdate.isPresent()).isEqualTo(true);
        assertThat(findedUpdate.get().getNom()).isEqualTo(updatedPays.getNom()) ;
        assertThat(findedUpdate.get().getCode()).isEqualTo(updatedPays.getCode()) ;
        assertThat(findedUpdate.get().getCapitale()).isEqualTo(updatedPays.getCapitale()) ;
        assertThat(findedUpdate.get().getDevise()).isEqualTo(updatedPays.getDevise()) ;
        assertThat(findedUpdate.get().getFrais()).isEqualTo(updatedPays.getFrais()) ;
        assertThat(findedUpdate.get().getTaux_echange()).isEqualTo(updatedPays.getTaux_echange()) ;



    }

    @Test
    @Order(3)
    void getAll() {
        List<Pays> foundedPays = paysService.getAll();
        assertThat(foundedPays).isInstanceOf(List.class);
        assertThat(foundedPays).isNotNull();
        assertThat(foundedPays.size()).isEqualTo(1);
    }

    @Test
    @Order(4)
    void getById() {
        Optional<Pays> foundedPays = paysService.getById(resultat.getId());
        assertThat(foundedPays.isPresent()).isEqualTo(true);
        assertThat(foundedPays.get()).isInstanceOf(Pays.class);
        assertThat(foundedPays).isNotNull();
        assertThat(foundedPays.get().getNom()).isEqualTo(resultat.getNom());
        assertThat(foundedPays.get().getCode()).isEqualTo(resultat.getCode());
        assertThat(foundedPays.get().getCapitale()).isEqualTo(resultat.getCapitale());
    }

    @Test
    @Order(5)
    void deleteById() {
        paysService.deleteById(resultat.getId());
    }




    /*
    *
    * @BadCasesTesting
    *
    * */


    /*
    *
    * @InputFilteringCasesTesting
    *
    * */

    @AfterAll
    void ResetPaysCollection(){
        paysRepository.deleteAll();
    }
}