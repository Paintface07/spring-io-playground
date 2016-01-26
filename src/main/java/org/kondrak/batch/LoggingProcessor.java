package org.kondrak.batch;

import org.kondrak.batch.model.Record;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 1/25/2016.
 */
public class LoggingProcessor implements ItemProcessor<Record, Record> {

    public Record process(Record r){
        System.out.println(r.getJobNumber());
        return r;
    }
}
