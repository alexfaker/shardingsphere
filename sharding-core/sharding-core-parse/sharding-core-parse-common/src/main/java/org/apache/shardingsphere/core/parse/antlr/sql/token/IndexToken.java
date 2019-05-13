/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.parse.antlr.sql.token;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.shardingsphere.core.parse.antlr.constant.QuoteCharacter;
import org.apache.shardingsphere.core.parse.antlr.sql.Substitutable;
import org.apache.shardingsphere.core.parse.util.SQLUtil;

/**
 * Index token.
 *
 * @author caohao
 * @author panjuan
 */
@Getter
@Setter
@ToString
public final class IndexToken extends SQLToken implements Substitutable {
    
    private final String indexName;
    
    private final int stopIndex;
    
    private String tableName;
    
    private final QuoteCharacter quoteCharacter;
    
    public IndexToken(final int startIndex, final int stopIndex, final String indexName) {
        super(startIndex);
        this.indexName = SQLUtil.getExactlyValue(indexName);
        this.stopIndex = stopIndex;
        quoteCharacter = QuoteCharacter.getQuoteCharacter(indexName);
    }
    
    public IndexToken(final int startIndex, final int stopIndex, final String indexName, final String tableName) {
        this(startIndex, stopIndex, indexName);
        this.tableName = tableName;
    }
    
    /**
     * Get table name.
     *
     * @return table name
     */
    public String getTableName() {
        return SQLUtil.getExactlyValue(tableName);
    }
}
