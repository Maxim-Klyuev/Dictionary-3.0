package mmtr.klyuev.dictionary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("mmtr.klyuev.dictionary")
public class ApplicationConfig {
    @Bean
    @Scope("prototype")
    public ConsoleMenu consoleMenu() {
        return new ConsoleMenu();
    }

    @Bean
    public DictionaryStorage dictionaryStorageOnFileSystem() {
        return new DictionaryStorageOnFileSystem();
    }

    @Bean
    public DictionaryMatchingCondition digitDict() {
        return new DigitDict();
    }

    @Bean
    public DictionaryMatchingCondition latinDict() {
        return new LatinDict();
    }

    @Bean
    public CheckMenuItems checkExitPointFromMethod() {
        return new CheckExitPointFromMethod();
    }

    @Bean
    public CheckMenuItems checkingDictionaryActionSelection() {
        return new CheckingDictionaryActionSelection();
    }

    @Bean
    public CheckMenuItems checkingDictionarySelection() {
        return new CheckingDictionarySelection();
    }
}