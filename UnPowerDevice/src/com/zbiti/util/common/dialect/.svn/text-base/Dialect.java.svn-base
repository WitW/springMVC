package com.zbiti.util.common.dialect;

public interface Dialect {
    public boolean supportsLimit();

    public String getLimitString( String sql, boolean hasOffset, int offset, int limit );

    public String getLimitString( String sql, int offset, int limit );
}
