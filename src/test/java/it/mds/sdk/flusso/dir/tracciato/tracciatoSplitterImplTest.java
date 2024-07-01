/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.dir.tracciato;

import it.mds.sdk.flusso.dir.parser.regole.ParserTracciatoImpl;
import it.mds.sdk.flusso.dir.parser.regole.RecordDtoDir;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import it.mds.sdk.libreriaregole.parser.ParserTracciato;
import it.mds.sdk.libreriaregole.tracciato.TracciatoSplitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TracciatoSplitterImplTest {

    private static final String FILE_TRACCIATO_DIR = "tracciato-dir-test.csv";

    @Test
    void dividiTracciatoTest() {
        ParserTracciato parserTracciato = new ParserTracciatoImpl();
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        File tracciato = new File(absolutePath + FileSystems.getDefault().getSeparator() + FILE_TRACCIATO_DIR);
        List<RecordDtoGenerico>  listaRecord= parserTracciato.parseTracciato(tracciato);
        TracciatoSplitter<RecordDtoDir> impl = new TracciatoSplitterImpl();
        //impl.dividiTracciato(listaRecord.stream().map(element ->(RecordDtoDir)element).collect(Collectors.toList()));

    }
}