import unittest
from assertpy import assert_that


def years_calc(n, planet):
    d = 0
    if planet == 'Merkury':
        d = 0.2408467
    if planet == 'Wenus':
        d = 0.61519726
    if planet == 'Mars':
        d = 1.8808158
    if planet == 'Jowisz':
        d = 11.862615
    if planet == 'Saturn':
        d = 29.447498
    if planet == 'Uran':
        d = 84.016846
    if planet == 'Neptun':
        d = 164.79132
    if planet == 'Ziemia':
        d = 1
    try:
        if n >= 0:
            return round(n / (31557600 * d), 2)
    except Exception:
        pass
    raise ValueError('Incorrect input')


class TestYearsCalc(unittest.TestCase):
    def test_years_calc_ziemia(self):
        assert_that(years_calc(1000000000, 'Ziemia')).is_close_to(31.69, 0.25)

    def test_years_calc_wenus(self):
        assert_that(years_calc(1000000000, 'Wenus')).is_greater_than(51)

    def test_years_calc_mars(self):
        assert_that(years_calc(1000000000, 'Mars')).is_less_than(17)

    def test_years_calc_mars2(self):
        assert_that(years_calc(1000000000, 'Mars')).is_not_none()

    def test_years_calc_jowisz(self):
        assert_that(years_calc(1000000000, 'Jowisz')).is_not_equal_to(1)

    def test_years_calc_saturn(self):
        assert_that(years_calc(1000000000, 'Saturn'))\
            .is_less_than_or_equal_to(1.08)

    def test_years_calc_uran(self):
        assert_that(years_calc(1000000000, 'Uran'))\
            .is_greater_than_or_equal_to(0.38)

    def test_years_calc_bad_planet(self):
        assert_that(years_calc).raises(ValueError).\
            when_called_with(1000000000, 'Krypton')

    def test_years_calc_bad_value(self):
        assert_that(years_calc).raises(ValueError).\
            when_called_with(-100000000000, 'Ziemia')

    def test_years_calc_bad_value_and_planet(self):
        assert_that(years_calc).raises(ValueError).\
            when_called_with('@@@@', 'Ziemia')
