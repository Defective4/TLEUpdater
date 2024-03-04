# TLEUpdater

Downloads TLE data from [isstracker.pl](https://isstracker.pl/)

## About

This is a simple project i made to help me keep my data for Orbitron up to date.

## Usage

```bash
java -jar TLEUpdater.jar <NORAD IDs...>
```

### Example

```bash
java -jar TLEUpdater.jar 33591 28654 25338 > noaa.txt
```

The above example reads TLE data about NOAA 19, 18 and 15 satellites and stores it in a text file