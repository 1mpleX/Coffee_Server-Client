package com.coffee.Controller;

import com.coffee.Kafka.MyKafkaProducer;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("api/coffee/kafka")
public class MyKafkaController {

    private final MyKafkaProducer myKafkaProducer;

    public MyKafkaController(MyKafkaProducer myKafkaProducer) {
        this.myKafkaProducer = myKafkaProducer;
    }

    @Operation(summary = "add info in Kafka",
            description = "send info with Kafka")
    @PostMapping("/{country}/{robusta_persentage}/{arabica_persentage}")
    public String kafkaZernoInfo(
            @Parameter(description = "country: ") @PathVariable String country,
            @Parameter(description = "robusta persentage:") @PathVariable double robusta_persentage,
            @Parameter(description = "arabica persentage: ") @PathVariable double arabica_persentage
    ) {
        // Отправка данных как одного сообщения, если нужно
        myKafkaProducer.sendMessage("Country: " + country +
                ", Robusta: " + robusta_persentage + "%" +
                ", Arabica: " + arabica_persentage + "%");

        // Можно сделать возврат JSON объекта
        return "Country: " + country + ", Robusta persentage: " + robusta_persentage + ", Arabica persentage: " + arabica_persentage;
    }
}
