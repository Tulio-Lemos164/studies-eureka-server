package br.com.mscards.service;

import br.com.mscards.model.Card;
import br.com.mscards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Card insert(Card card){
        return cardRepository.save(card);
    }

    @Transactional(readOnly = true)
    public List<Card> findCardIncomeLowerOrEqualTo(Long income){
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
