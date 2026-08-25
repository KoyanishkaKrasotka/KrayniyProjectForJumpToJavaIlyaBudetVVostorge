package ru.jumptojava.kinopoiskz.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.FilmsXmlWrapper;
import ru.jumptojava.kinopoiskz.entity.Film;

import java.io.StringWriter;
import java.util.List;

@Service
public class ReportService {

    public String generateCsv(List<Film> films) {
        StringBuilder sb = new StringBuilder();
        sb.append("id,filmId,filmName,year,rating,description\n");

        for (Film film : films) {
            sb.append(film.getId()).append(",")
                    .append(film.getFilmId()).append(",")
                    .append(film.getFilmName()).append(",")
                    .append(film.getYear()).append(",")
                    .append(film.getRating()).append(",")
                    .append(film.getDescription()).append("\n");
        }

        return sb.toString();
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
