var router = require('express').Router();
var cajeros = require('../controllers/cajeros.controller')

router.get('/cajeros',cajeros.listarCajeros)

module.exports = router