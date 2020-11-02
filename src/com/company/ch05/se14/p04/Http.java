package com.company.ch05.se14.p04;

import java.io.IOException;

public interface Http {
    String get(String targetUrl) throws IOException;
}
