package org.rhythm.service;

import java.io.InputStream;

public interface CppService {
    String compile();
    String executeCppFile();
    String readOutputFile(InputStream inputStream);
}
