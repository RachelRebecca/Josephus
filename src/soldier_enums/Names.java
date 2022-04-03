package soldier_enums;

/**
 * Enum class with list of names and toString() method for more appealing spelling
 */
public enum Names
{
    ATTICUS ("Atticus"),
    FELIX ("Felix"),
    CASSIUS ("Cassius"),
    CYRUS ("Cyrus"),
    MAGNUS ("Magnus"),
    AURELIUS ("Aurelius"),
    LUCIUS ("Lucius"),
    CAIUS ("Caius"),
    IGNATIUS ("Ignatius"),
    RUFUS ("Rufus"),
    THADDEUS ("Thaddeus"),
    AUGUSTUS ("Augustus"),
    REMUS ("Remus"),
    LINUS ("Linus"),
    JULIUS ("Julius"),
    DARIUS ("Darius"),
    MAXIMUS ("Maximus"),
    MARCUS ("Marcus"),
    SIRIUS ("Sirius"),
    MARIUS ("Marius"),
    ALOYSIUS ("Aloysius"),
    AMADEUS ("Amadeus"),
    CATO ("Cato"),
    OCTAVIUS ("Octavius"),
    OCTAVIAN ("Octavian"),
    TIBERIUS ("Tiberius"),
    CORNELIUS ("Cornelius"),
    SEVERUS ("Severus"),
    CLETUS ("Cletus"),
    SEPTIMUS ("Septimus"),
    GAIUS ("Gaius"),
    ERASMUS ("Erasmus"),
    BRUTUS ("Brutus"),
    JUSTUS ("Justus"),
    BARNABAS ("Barnabas"),
    CYPRIAN ("Cyprian"),
    THEOPHILUS ("Theophilus"),
    URBAN ("Urban"),
    JASON ("Jason"),
    ZEPHYRUS ("Zephyrus"),
    PHILO ("Philo"),
    CALIBAN ("Caliban"),
    SILVANUS ("Silvanus"),
    CADMUS ("Cadmus"),
    FLORIN ("Florin"),
    CLAUDIUS ("Claudius"),
    QUINTUS ("Quintus"),
    FLAVIUS ("Flavius"),
    PHINEAS ("Phineas"),
    AMBROSIUS ("Ambrosius"),
    CECILIUS ("Cecilius"),
    EVANDER ("Evander"),
    PLUTO ("Pluto"),
    ROMAN ("Roman"),
    ROMULUS ("Romulus"),
    ULYSSES ("Ulysses"),
    VULCAN ("Vulcan"),
    LEO ("Leo"),
    MILO ("Milo"),
    SPURIOUS ("Spurious"),
    DELPHI ("Delphi"),
    FELICE ("Felice"),
    MARCELLUS ("Marcellus"),
    TITAN ("Titan"),
    FLOREAN ("Florean"),
    FLAVIAN ("Flavian"),
    THEO ("Theo"),
    THEODICIUS ("Theodicius"),
    LARRY ("Larry"),
    PERSEUS ("Perseus"),
    ALECTO ("Alecto"),
    AMYCUS ("Amycus"),
    CALIGULUS ("Caligulus"),
    ANIMAGUS ("Animagus"),
    CACTUS ("Cactus"),
    CYPRUS ("Cyprus"),
    CITRUS ("Citrus"),
    FLAVIO ("Flavio"),
    NEMESES ("Nemeses"),
    THETO ("Theto"),
    NIGELLUS ("Nigellus"),
    FIDO ("Fido");

    private final String nameString;

    /**
     * Name Enum constructor
     * @param name: the more appealing spelling of the name
     */
    Names(String name)
    {
        nameString = name;
    }

    /**
     * represents the Name Enum value as a String
     * @return the Name Enum in its appealing form
     */
    public String toString()
    {
        return nameString;
    }
}
