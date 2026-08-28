package ru.jumptojava.kinopoiskz.service;

import com.opencsv.CSVWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.FilmsXmlWrapper;
import ru.jumptojava.kinopoiskz.entity.Film;
import ru.jumptojava.kinopoiskz.repository.FilmRepository;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Service
public class ReportService {

    private final FilmRepository filmRepository;

    public ReportService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public String generateReport(String format) throws JAXBException,IOException {
        List<Film> films = filmRepository.findAll();

        return format.equals("xml") ? generateXml(films) : generateCsv(films);
    }

    public String generateCsv(List<Film> films) throws IOException {
        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);

        csvWriter.writeNext(new String[]{"id", "filmId", "filmName", "year", "rating", "description"});

        for (Film film : films) {
            csvWriter.writeNext(new String[]{
                    String.valueOf(film.getId()),
                    String.valueOf(film.getFilmId()),
                    film.getFilmName(),
                    String.valueOf(film.getYear()),
                    String.valueOf(film.getRating()),
                    film.getDescription()
            });
        }

        csvWriter.close();
        return stringWriter.toString();
    }

    public String generateXml(List<Film> films) throws JAXBException {
        FilmsXmlWrapper wrapper = new FilmsXmlWrapper(films);

        JAXBContext context = JAXBContext.newInstance(FilmsXmlWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(wrapper, writer);

        return writer.toString();
    }
}
