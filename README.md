# Van Gogh Museum Automation
Test execution results: [![Allure Report](https://img.shields.io/badge/Allure%20Report-deployed-yellowgreen)](https://melmoth-der-wanderer.github.io/ideal-eureka-gm/)
---
Project: Van Gogh Museum: https://www.vangoghmuseum.nl/nl
---

### Technology
Selenium WebDriver, Maven, Allure Report

---

### Browsers
Chrome

---

### CI
Have been used Github Actions. Job is running automatically on the `push` action. See details `.github/workflows/e2e_tests.yml`.
## Local Set Up

Clone the repository to your local computer
```
git clone https://github.com/melmoth-der-wanderer/ideal-eureka-gm.git
```

Run the UI automation tests in parallel:
```
mvn cleant test
```
---

#### Notes:

- Structure should be discussed via pull-request procedure with a team;
- Mobile emulation is also possible, but wasn't considered in this project as it is completely adaptive.
